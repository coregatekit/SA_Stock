import { Component } from '@angular/core';
import { _getComponentHostLElementNode } from '@angular/core/src/render3/instructions';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'StockV2';

  constructor(private router:Router){}
  goHome() { this.router.navigate(['/']); }
  goStock() { this.router.navigate(['/Stock']); }
  goRegister() { this.router.navigate(['/Register']); }
}
