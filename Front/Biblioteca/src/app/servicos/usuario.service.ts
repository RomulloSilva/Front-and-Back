import { Injectable } from '@angular/core';
import {Usuario} from '../model/Usuario';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

  public autenticar(usuario: Usuario){
    return this.http.post("http://localhost:8080/login", usuario)
  }

}
