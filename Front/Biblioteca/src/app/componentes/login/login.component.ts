import { Component, OnInit } from '@angular/core';

import {UsuarioService} from '../../servicos/usuario.service';
import {Usuario} from '../../model/Usuario';
import {Token} from '../../model/Token';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  private usuario: Usuario = new Usuario();

  constructor(private srv: UsuarioService, private router:Router) { }

  ngOnInit() {

    if(localStorage.getItem("romuloToken")){
      this.router.navigate(['/catalogo']);
    }

  }


  public enviarDados(){
    console.log(this.usuario);
    this.srv.autenticar(this.usuario).subscribe((res: Token)=>{
      //Se de certo armazena token na memoria local.
      localStorage.setItem("romuloToken", res.construindoToken);


      //Envia para a página de catalogo.
      this.router.navigate(['/catalogo'])
    },
    (err)=>{
      alert("ERRO");
    })
  }

}
