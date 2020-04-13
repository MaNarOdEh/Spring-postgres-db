import { login, singout } from "./login.action";
import { Action, on, createReducer } from "@ngrx/store";

export const isLogin = false;

/*State changes are handled by pure functions (reducer)*/
const _loginReducer = createReducer(
  isLogin,
  on(login, (state) => (state = true)),
  on(singout, (state) => (state = false))
);
export function reducer(state, action: Action) {
  return _loginReducer(state, action);
}
