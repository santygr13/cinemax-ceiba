import { Component, OnInit } from '@angular/core';

import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { SalacineService } from '../../../../shared/services/salacine.service';
import { SalaCine } from '../../../../shared/model/salacine';


@Component({
  selector: 'app-crearsalacine',
  templateUrl: './crearsalacine.component.html',
  styleUrls: ['./crearsalacine.component.css']
})
export class CrearsalacineComponent implements OnInit {


  public salacine: SalaCine = new SalaCine()
  form: NgForm

  constructor(private salaCineService: SalacineService, private router: Router) { }


  ngOnInit() {
    
  }

  
  OnSubmit(form:NgForm){
    console.log(this.salacine)
    this.salaCineService.create(this.salacine)
    .subscribe(Response=>{
      this.router.navigate(['/principal'])
      Swal.fire({
      position:'center',
      icon:'success',
      title:'Registro Exitoso',
      text:'La sala de cine  se creo con exito',
      showConfirmButton:true
      });
      
    });
  
  }
 

}
