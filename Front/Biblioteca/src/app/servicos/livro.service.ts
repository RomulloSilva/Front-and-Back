import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LivroService {

  constructor(private http: HttpClient) {}


    public getAllLivros(){

      let token = localStorage.getItem("romuloToken");
      return this.http.get("http://localhost:8080/catalogo?token="+token);
    }
   


   
}
