import { Component, OnInit } from '@angular/core';
import { HttpClientService, User } from '../service/http-client.service';


@Component({
  selector: 'app-add_user',
  templateUrl: './add_user.component.html',
  styleUrls: ['./add_user.component.css']
})
export class AddUserComponent implements OnInit {

  user: User = new User("","","","","","",[1,2]);


  constructor(
    private httpClientService:HttpClientService
  ) { }

  ngOnInit(): void {
  }

  addUser():void{
    this.httpClientService.addUser(this.user).subscribe(
      data =>{ alert("User has been created");
    }
    );
  };

}
