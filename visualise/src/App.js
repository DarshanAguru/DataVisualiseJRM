
import './App.css';

import Dashboard from '/Dashboard';

import Footer from './Footer';

import { useState } from 'react';

function App() {

  const [hovered, setHovered] = useState(false);
  const toggleClass = ()=>{
    setHovered(!hovered);
  }

  return (
    <div className="App">
      <header className="App-header">
        <h1 className={!hovered ? 'uncoloured-head' : 'coloured-head'} onMouseEnter={toggleClass} onMouseLeave={toggleClass}>Dash</h1>
        <h1  className={!hovered ? 'coloured-head' : 'uncoloured-head'} onMouseEnter={toggleClass} onMouseLeave={toggleClass} >Board</h1>   
      </header>
      <Dashboard/>
      <Footer/>
    </div>
    
  );
}

export default App;
