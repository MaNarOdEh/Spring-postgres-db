import { Action, on, createReducer } from "@ngrx/store";
import { login, singout } from "../Action/login.action";

export const isLogin = false;

/*State changes are handled by pure functions (reducer)
we create a reducer that it will handle & dealing with each action*/
const _loginReducer = createReducer(
  isLogin,
  on(login, (state) => (state = true)),
  on(singout, (state) => (state = false))
);

/*Action is an interface that have anattributes called type*/
export function reducer(state, action: Action) {
  return _loginReducer(state, action);
}
