import './App.css';
import { RouterProvider } from 'react-router-dom';
import { router } from './router';
import { GlobalUserProvider } from './contexts/user/user.contexts';

function App() {
  return (
    <GlobalUserProvider>
      <RouterProvider router={router} />
    </GlobalUserProvider>
  );
}

export default App;
