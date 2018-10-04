import { Component, OnInit } from '@angular/core';
import { StockService } from '../shared/stock/stock.service';

export interface PeriodicElement {
  productName: string;
  productDetail: string;
  productImgUrl: string;
  productProce: number;
}
/*
export interface CountryList {
  value: string;
  viewValue: string;
}
export interface WHTH {
  value: string;
  viewValue: string;
}
export interface WHAB {
  value: string;
  viewValue: string;
}
export interface Products {
  value: string;
  viewValue: string;
}
export interface FinalDestination {
  value: string;
  viewValue: string;
}
*/
@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {
  inputNewProductName:string = '';    inputNewProductDetail:string = '';
  inputNewProductImgUrl:string = '';  inputNewProductPrice:number = 0;
  product: Array<any>;
  warehouses: Array<any>;
  /*
  WCList: CountryList[] = [
    {value: 'LOSANGELES', viewValue: 'Los Angeles, CA'},
    {value: 'MIAMI', viewValue: 'Miami, FL'},
    {value: 'NEWYORK', viewValue: 'New York, NY'},
    {value: 'LONDON', viewValue: 'London, UK'},
    {value: 'BERLIN', viewValue: 'Berlin, Germany'},
    {value: 'PARIS', viewValue: 'Paris, France'},
    {value: 'TOKYO', viewValue: 'Tokyo, Japan'},
    {value: 'SEOUL', viewValue: 'Seoul, South Korea'},
    {value: 'TAIPEI', viewValue: 'Taipei, Taiwan'},
    {value: 'Singapore', viewValue: 'Singapore'}
  ];

  ab_warehouse: WHAB[] = [
    {value: 'LOSANGELES', viewValue: 'Los Angeles, CA'},
    {value: 'MIAMI', viewValue: 'Miami, FL'},
    {value: 'NEWYORK', viewValue: 'New York, NY'},
    {value: 'LONDON', viewValue: 'London, UK'},
    {value: 'BERLIN', viewValue: 'Berlin, Germany'},
    {value: 'PARIS', viewValue: 'Paris, France'},
    {value: 'TOKYO', viewValue: 'Tokyo, Japan'},
    {value: 'SEOUL', viewValue: 'Seoul, South Korea'},
    {value: 'TAIPEI', viewValue: 'Taipei, Taiwan'},
    {value: 'Singapore', viewValue: 'Singapore'}
  ];

  th_warehouse: WHTH[] = [
    {value: 'CMI', viewValue: 'เชียงใหม่'},
    {value: 'PTE', viewValue: 'ปทุมธานี'},
    {value: 'NMA', viewValue: 'นครราชสีมา'},
    {value: 'CBI', viewValue: 'ชลบุรี'},
    {value: 'PKN', viewValue: 'ประจวบคีรีขันธ์'}
  ];

  products_list: Products[] = [
    {value: 'AAA', viewValue: 'AAA'},
    {value: 'BBB', viewValue: 'BBB'},
    {value: 'CCC', viewValue: 'CCC'},
    {value: 'DDD', viewValue: 'DDD'},
    {value: 'EEE', viewValue: 'EEE'}
  ];

  final_destination: FinalDestination[] = [
    {value: 'PTE', viewValue: 'ปทุมธานี'}
  ];
  */

  constructor(private stockService: StockService) { }

  ngOnInit() {
    this.stockService.getOrderProduct().subscribe(data => {
      this.warehouses = data;
      console.log(this.warehouses);
    });
  }

  addNewProduct() {
    this.stockService.addNewProduct(this.inputNewProductName, this.inputNewProductDetail, this.inputNewProductImgUrl, this.inputNewProductPrice).subscribe(
      data => {
        console.log("POST Request is successful", data);
        this.inputNewProductName = '';
        this.inputNewProductDetail = '';
        this.inputNewProductImgUrl = '';
        this.inputNewProductPrice = 0;
      },
      error => {
        console.log("Error", error);
      }
    );
  }

}
