import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class StockService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getStock(): Observable<any> {
    return this.http.get(this.API + '/Stock');
  }

  getProduct(): Observable<any> {
    return this.http.get(this.API + '/Product');
  }

  getOrderProduct(): Observable<any> {
    return this.http.get(this.API + '/OrderProduct');
  }

  getWarehouse(): Observable<any> {
    return this.http.get(this.API + '/Warehouse');
  }

  public addNewProduct(newProductName:string, newProductDetail:string, newProductImgUrl:string, newProductPrice:number):Observable<any> {
      return this.http.put(this.API + '/Product/addProduct/'+newProductName+'/'+newProductDetail+'/'+newProductImgUrl+'/'+newProductPrice,{
        "productName":newProductName,
        "productDetail":newProductDetail,
        "productImgUrl":newProductImgUrl,
        "productPrice":newProductPrice
      });
  }
}
