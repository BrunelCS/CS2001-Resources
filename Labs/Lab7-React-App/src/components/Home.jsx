import useFetchData from "../customHooks/useFetchData";

export default function Home(){
    const {data, error, loading } = useFetchData('http://localhost:8080/hello')
    if (loading) return <div>Loading...</div>;
    if (error) return <div>Error: {error.message}</div>;

    console.log(data)
    return(
        <div>
            <p>{data}</p>
        </div>
       
    )

}