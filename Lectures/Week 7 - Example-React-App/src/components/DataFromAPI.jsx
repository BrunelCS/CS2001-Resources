import { Link, Outlet } from 'react-router-dom'

import useFetchData from '../customHooks/useFetchData.jsx'

function DataFromAPI() {
    const {data, error, loading } = useFetchData('https://reqres.in/api/users/2');
  
    if (loading) return <div>Loading...</div>;
    if (error) return <div>Error: {error.message}</div>;
  
    return(
    
         <div className="maincontent">
            {JSON.stringify(data)}
            <Link to="details">Details</Link>
            <Outlet context={{"user":data.data.email}}/>
         </div>
         )
  }

export default DataFromAPI;