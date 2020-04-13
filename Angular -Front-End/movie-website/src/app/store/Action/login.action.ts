import { createAction, props, Action } from "@ngrx/store";

export const login = createAction(
  "[Login Page] Login",
  props<{ username: string; password: string }>()
);
export const singout = createAction("[Signout Page] Signout");

/*
createAction method will create a class for each action
you can assume that the first action login will be something like that


  export class login implements Action{
    type:string='login';
    public constructor(public username,public password){
      
    }
  }
  export class signout implements Action{
    type:string='signout'
  }

  
*/
