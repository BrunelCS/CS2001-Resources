import React from 'react';
import Header from './Header';  // Import the Header component
import Sidebar from './Sidebar';  // Import the Sidebar component
import Registration from './Registration';  // Import the Registration form component
import './App.css';  // Import the CSS for styling

const App = () => {
  return (
    <div className="app-container">
      <Header /> {/* Header at the top */}
      <div className="content-container">
        <Sidebar />  {/* Sidebar on the left */}
        <main>
          <Registration /> {/* Main content with Registration form */}
        </main>
      </div>
    </div>
  );
}

export default App;