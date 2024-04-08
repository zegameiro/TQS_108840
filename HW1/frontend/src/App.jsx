import { BrowserRouter, Route, Routes } from 'react-router-dom'

import HomePage from './pages/HomePage';
import BusTrips from './pages/BusTrips';

const App = () => {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/homepage" element={<HomePage />} />
          <Route path="/bustrips" element={<BusTrips />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App
