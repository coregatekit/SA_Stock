import { Component, OnInit, ViewChild } from '@angular/core';
import { StockService } from '../shared/stock/stock.service';
import { NgForm } from '@angular/forms';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';

export interface WarehouseList {
  warehouseId;
  warehouseAddress;
  warehouseCode;
  warehouseName;
}
export interface OrderproductList {
  orderproductId: number;
  preorderId: number;
  amount: number;
  totalPrice: number;
}
@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {
  productSelect;
  warehouseSelect;
  disWarehouseSelect;
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

  ThaiWarehouseLists: Array<any>;
  AboardWarehouseLists: Array<any>;

  displayedColumns: string[] = ['orderproductId', 'preorderId', 'amount', 'totalPrice'];
  dataSource: MatTableDataSource<OrderproductList>;
  product: any = {
    productName: '',
    productImgUrl: '',
    productDetail: '',
    productPrice: ''
  };
  editProductData: any = {
    id: '',
    productName: '',
    productImgUrl: '',
    productDetail: '',
    productPrice: ''
  };

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

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
      const orderProductList: OrderproductList[] = [];
      console.log(this.orderProducts);
      for (let index = 0; index < this.orderProducts["length"]; index++) {
        orderProductList.push({
          orderproductId: this.orderProducts[index].orderproductId,
          preorderId: this.orderProducts[index].preorderId,
          amount: this.orderProducts[index].amount,
          totalPrice: this.orderProducts[index].totalPrice,
        });
        }
        this.dataSource = new MatTableDataSource(orderProductList);
        this.dataSource.paginator = this.paginator;
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
      this.ThaiWarehouseLists = ThaiWarehouseLists;
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
        alert('Add new product succesfull!');
      },
      error => {
        console.log('Error! cannot add new product!', error);
      }
    );
  }
  addProduct2(product: NgForm) {
    console.log(product);
    this.stockService.addProduct2(product).subscribe(
      data => {
        alert('Add new product succesfull!');
        console.log('Add new product succesfull!', data);
        this.getProductList();
        this.product.productName = '';
        this.product.productDetail = '';
        this.product.productImgUrl = '';
        this.product.productPrice = '';
      },
      error => {
        console.log('Error! cannot add new product!', error);
      }
    );
  }

  editProduct() {
    console.log('editProduct');
    alert(this.editProductId);
    if(this.editNewProductName == '' || this.editProductDetail == '' || this.editProductImgUrl == '' || this.editProductPrice == 0) {
      alert('กรอกข้อมูลไม่ครบถ้วน กรุณากรอกข้อมูลใหม่');
    } else {
      this.stockService.editProduct(this.editProductId, this.editNewProductName, this.editProductDetail, this.editProductImgUrl, this.editProductPrice).subscribe(
        data => {
          console.log("Edit product succesfull!", data);
          this.getProductList();
          this.editNewProductName = '';
          this.editProductDetail = '';
          this.editProductImgUrl = '';
          this.editProductPrice = null;
        }
      );
    }
  }

  editProduct2(editProductData: NgForm) {
    console.log(editProductData);
    if(this.editProductData.productName === '' || this.editProductData.productDetail === '' ||
     this.editProductData.editProductImgUrl === '' || this.editProductData.productPrice === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.stockService.editProduct2(editProductData).subscribe(
        data => {
          alert('Edit product succesfull!');
          this.getProductList();
          this.editProductData.id = '';
          this.editProductData.productName = '';
          this.editProductData.productImgUrl = '';
          this.editProductData.productDetail = '';
          this.editProductData.productPrice = '';
        }
      );
    }
  }
}
