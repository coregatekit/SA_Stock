import { Component, OnInit, ViewChild } from '@angular/core';
import { StockService } from '../shared/stock/stock.service';
import { MatPaginator, MatTableDataSource } from '@angular/material';
import { NgForm } from '@angular/forms';

export interface WarehouseList {
  warehouseId;
  warehouseAddress;
  warehouseCode;
  warehouseName;
}
@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {
  productSelect;
  warehouseSelect;
  ordWarehouseSelect;
  stocks: Array<any>;
  orderProducts: Array<any>;
  products: any;
  warehouses: Array<any>;
  ordProductId: number;
  ordPreorderId: number;
  ordWarehouseId: number;
  ordProductAmount: number;
  ordTotalPrice: number;
  newProductName: string = '';
  newProductDetail: string = '';
  newProductImgUrl: string = '';
  newProductPrice: number;
  editProductId: number;
  editNewProductName: string = '';
  editProductDetail: string = '';
  editProductImgUrl: string = '';
  editProductPrice: number;

  ThaiWarehouseList: Array<any>;
  AboardWarehouseLists: Array<any>;

  product: any = {
    productName: '',
    productImgUrl: '',
    productDetail: '',
    productPrice: ''
  };

  @ViewChild(MatPaginator) thaiWarehousePaginator: MatPaginator;
  @ViewChild(MatPaginator) aboardWarehousePaginator: MatPaginator;


  constructor(private stockService: StockService) { }
  ngOnInit() {
    this.getStockList();
    this.getOrderProductList();
    this.getProductList();
    this.getWarehouseList();
  }

  getStockList() {
    this.stockService.getStock().subscribe(data => {
      this.stocks = data;
      console.log(this.stocks);
    });
  }
  getOrderProductList() {
    this.stockService.getOrderProduct().subscribe(data => {
      this.orderProducts = data;
      console.log(this.orderProducts);
    });
  }
  getProductList() {
    this.stockService.getProduct().subscribe(data => {
      this.products = data;
      console.log(this.products);
    });
  }
  getWarehouseList() {
    this.stockService.getWarehouse().subscribe(data => {
      this.warehouses = data;
      console.log(this.warehouses);
      const ThaiWarehouseLists: WarehouseList[] = [];
      const AboardWarehouseLists: WarehouseList[] = [];
      for (let index = 0; index < data['length']; index++) {
        if (data[index].warehouseAddress === 'THAI') {
          ThaiWarehouseLists.push({
            warehouseId: data[index].id,
            warehouseAddress: data[index].warehouseAddress,
            warehouseCode: data[index].warehouseCode,
            warehouseName: data[index].warehouseName
          });
        } else {
          AboardWarehouseLists.push({
            warehouseId: data[index].id,
            warehouseAddress: data[index].warehouseAddress,
            warehouseCode: data[index].warehouseCode,
            warehouseName: data[index].warehouseName
          });
        }
      }
      this.ThaiWarehouseList = ThaiWarehouseLists;
      this.AboardWarehouseLists = AboardWarehouseLists;
      console.log(ThaiWarehouseLists);
      console.log(AboardWarehouseLists);
    });
  }


  addOrder() {
    this.stockService.addOrder(this.ordProductId, this.ordProductAmount,
       this.ordTotalPrice, this.ordPreorderId, this.ordWarehouseId).subscribe(
      data => {
        console.log('Add order succesfull!', data);
        this.getOrderProductList();
        this.ordPreorderId = null;
        this.ordProductAmount = null;
        this.ordTotalPrice = null;
        this.ordPreorderId = null;
        this.ordWarehouseId = null;
      },
      error => {
        console.log('Error! cannot add new order', error);
      }
    );
  }
  addNewProduct(product: NgForm) {
    console.log(product);
    this.stockService.addNewProduct(product).subscribe(
      data => {
        console.log('Add new product succesfull!', data);
        this.getProductList();
        this.newProductName = '';
        this.newProductDetail = '';
        this.newProductImgUrl = '';
        this.newProductPrice = null;
      },
      error => {
        console.log('Error! cannot add new product!', error);
      }
    );
  }
  editProduct(product: NgForm) {
    console.log(product);
    alert(product);
    if(this.product.editNewProductName === '' || this.product.editProductDetail === '' ||
     this.product.editProductImgUrl === '' || this.product.editProductPrice === 0) {
      alert('กรอกข้อมูลไม่ครบถ้วน กรุณากรอกข้อมูลใหม่');
    } else {
      this.stockService.editProduct(/*this.editProductId, this.editNewProductName,
         this.editProductDetail, this.editProductImgUrl, this.editProductPrice*/ product).subscribe(
        data => {
          console.log('Edit product succesfull!', data);
          this.getProductList();
          this.editNewProductName = '';
          this.editProductDetail = '';
          this.editProductImgUrl = '';
          this.editProductPrice = null;
        }
      );
    }
  }
}
