import { Component, OnInit, ViewChild } from '@angular/core';
import { StockService } from '../shared/stock/stock.service';
import { MatPaginator, MatTableDataSource } from '@angular/material';
export interface PeriodicElement {
  productName: string;
  productDetail: string;
  productImgUrl: string;
  productProce: number;
}

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {

  stocks: Array<any>;
  orderProducts: Array<any>;
  products: Array<any>;
  warehouses: Array<any>;
  ordProductId: number;
  ordPreorderId: number;
  ordWarehouseId: number;
  ordProductAmount: number;
  ordTotalPrice: number;
  newProductName: string = '';
  newProductDetail: string = '';
  newProductImgUrl: string = '';
  newProductPrice: number = 0;

  @ViewChild(MatPaginator) paginator: MatPaginator;


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
    });
  }


  addOrder() {
    this.stockService.addOrder(this.ordProductId, this.ordProductAmount, this.ordTotalPrice, this.ordPreorderId, this.ordWarehouseId).subscribe(
      data => {
        console.log("Add order succesfull!", data);
        this.getOrderProductList();
        this.ordPreorderId = 0;
        this.ordProductAmount = 0;
        this.ordTotalPrice = 0;
        this.ordPreorderId = 0;
        this.ordWarehouseId = 0;
      },
      error => {
        console.log("Error! cannot add new order", error);
      }
    );
  }

  addNewProduct() {
    this.stockService.addNewProduct(this.newProductName, this.newProductDetail, this.newProductImgUrl, this.newProductPrice).subscribe(
      data => {
        console.log("Add new product succesfull!", data);
        this.getProductList();
        this.newProductName = '';
        this.newProductDetail = '';
        this.newProductImgUrl = '';
        this.newProductPrice = 0;
      },
      error => {
        console.log("Error! cannot add new product!", error);
      }
    );
  }
}
