import { Component, OnInit } from '@angular/core';

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

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {

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

  constructor() { }

  ngOnInit() {
  }

}
