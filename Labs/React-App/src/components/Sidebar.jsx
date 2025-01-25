import Weather from "./Weather";

export default function Sidebar(){
    return (
        <aside className="sidebar">
          <input type="text" className="search" id="search" name="search" placeholder="Search"></input>
          <Weather/>
        </aside>
    )
}