import { Component, OnInit } from '@angular/core';
import {Livro} from '../../model/Livro';
import {LivroService} from '../../servicos/livro.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-catalogo',
  templateUrl: './catalogo.component.html',
  styleUrls: ['./catalogo.component.css']
})
export class CatalogoComponent implements OnInit {


  lista: Livro[];//criamos uma var que armazenará todos os livros no formato da classe criada.

  constructor(private srv: LivroService, private route: Router) { }

  ngOnInit() {

    if(localStorage.getItem("romuloToken")){
      this.srv.getAllLivros().subscribe((res: Livro[])=>{
        console.log(res);
        this.lista = res;
      },
      (err)=>{
        this.route.navigate(['/home']);
      }
      );
    }else{
      this.route.navigate(['/home']);
    }

  }

  public reservar(){
    alert("Função não disponível no momento");
  }

}
