import useFetchData from "../customHooks/useFetchData";
import { useOutletContext } from "react-router-dom";

export default function Home(){
    const [token, setToken] = useOutletContext();
    const {data, error, loading } = token?useFetchData('http://localhost:8080/user/getDetails',token):{}
    
    if(!token) return <div>You are a guest user</div>
    if (loading) return <div>Loading...</div>;
    if (error) return <div>Error: {error.message}</div>;

    console.log(data)

    return(
        <div>
            <p>Hello {data.name}</p>
        </div>
        )
}