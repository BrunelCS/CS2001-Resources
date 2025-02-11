import useFetchData from "../customHooks/useFetchData";
import { useAuth } from "../customHooks/AuthContext";

export default function Home(){
    const {token, setToken} = useAuth();
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