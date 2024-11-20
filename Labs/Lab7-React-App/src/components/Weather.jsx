import useFetchData from "../customHooks/useFetchData"

export default function Weather(){
    const {data, error, loading } = useFetchData('https://api.open-meteo.com/v1/forecast?latitude=51.5085&longitude=-0.1257&current=temperature_2m&daily=temperature_2m_max,temperature_2m_min&timezone=Europe%2FLondon&forecast_days=1&models=ukmo_seamless');
  
    if (loading) return <div>Loading...</div>;
    if (error) return <div>Error: {error.message}</div>;

    console.log(data)
    return(
        <div>
            <p>Min: {data.daily.temperature_2m_min}&deg;</p>
            <p>Max: {data.daily.temperature_2m_max}&deg;</p>
        </div>
       
    )
}