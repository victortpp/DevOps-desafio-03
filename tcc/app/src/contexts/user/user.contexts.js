import createGlobalState from "react-create-global-state";

const [_useGlobalUser, GlobalUserProvider] = createGlobalState(null);

function useGlobalUser() {
  const [_user, _setUser] = _useGlobalUser();

  function setUser(user) {
    _setUser(user);
  }

  return [_user, setUser];
}

export { useGlobalUser, GlobalUserProvider };