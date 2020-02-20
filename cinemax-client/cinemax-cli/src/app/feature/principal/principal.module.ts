import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PrincipalRoutingModule } from './principal-routing.module';
import { PrincipalComponent } from './components/principal.component';
import { Module } from 'src/app/shared/shared.module';



@NgModule({
  declarations: [
    PrincipalComponent
  ],
  imports: [
    CommonModule,
    PrincipalRoutingModule,
    Module

  ],
  exports:[]
})
export class PrincipalModule { }
