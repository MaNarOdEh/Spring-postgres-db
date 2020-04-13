import { Action } from "@ngrx/store";

//the reducer function return the new state but does not change the state direct
export function reducerFunction(state, action: Action) {
  switch (action.type) {
    case "1":
    case "2":
    default:
      return state;
  }
}
