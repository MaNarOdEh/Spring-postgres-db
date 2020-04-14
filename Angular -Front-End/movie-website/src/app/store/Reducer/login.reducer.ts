import { Action, on, createReducer, State } from "@ngrx/store";
import { login, singout } from "../Action/login.action";

export interface LoginState {
  isLogin: boolean;
}
const isLogin: LoginState = { isLogin: false };

/*State changes are handled by pure functions (reducer)
we create a reducer that it will handle & dealing with each action*/
const _loginReducer = createReducer(
  isLogin,
  on(login, (state) => (state = { isLogin: true })),
  on(singout, (state) => (state = { isLogin: false }))
);
/**
 * _loginReducer(state,action){
 * switch action.type:
 * case 'login':
 * case 'signout':
 * default:
 * }
 *
 */
/*Action is an interface that have anattributes called type*/
export function reducer(state: LoginState | undefined, action: Action) {
  return _loginReducer(state, action);
}
