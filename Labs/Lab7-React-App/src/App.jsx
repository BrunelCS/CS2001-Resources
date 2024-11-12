import './App.css'
import Registration from './components/Registration'

function App() {
  

  return (
    <>
      <header></header>
      <div className="container">
          <aside className="sidebar">
            <input type="text" className="search" id="search" name="search" placeholder="Search"></input>
          </aside>
          <main className="maincontent">
              <Registration></Registration>
          </main>
      </div>
    </>
  )
}

export default App
