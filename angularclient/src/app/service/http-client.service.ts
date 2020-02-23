import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

export class User{
  constructor(
    public id:string,
    public firstName:string,
    public lastName:string,
    public login:string,
    public password:string,
    public active:string,
    public userIds:Number[],
  ){}
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(
    private httpClient:HttpClient
  ) { }

  getUser()
  {
    return this.httpClient.get<User[]>('http://localhost:8080/users');
  }

  public deleteUser(user) {
    return this.httpClient.delete<User[]>("http://localhost:8080/users/id" + "/?id="+ user.id);
  }

  public addUser(user) {
    return this.httpClient.put<User[]>('http://localhost:8080/users', user);
  }
}
