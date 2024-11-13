// Fetching data using external API and JSON file

import { useEffect, useState } from "react";

function Weather(){

    const [weatherData, setWeatherData] = useState(null);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchWeatherData = async () => {
            try {
                // await means wait until fetch is complete
                const response = await fetch("https://api.open-meteo.com/v1/forecast?latitude=51.5085&longitude=-0.1257&current=temperature_2m&daily=temperature_2m_max,temperature_2m_min&timezone=Europe%2FLondon&forecast_days=1&models=ukmo_seamless")
                
                if (!response.ok) {
                    throw new Error("Failed to fetch weather data");
                }

                const data = await response.json(); 
                setWeatherData(data);

            } catch(error) {
                setError(error.message);
            }
        };

        fetchWeatherData();
    }, []); // Empty dependency array ensure it only runs once on mount

    if (error) {
        return <div className="weather-error">Error: {error}</div>
    }

    if (!weatherData) {
        return <div className="weather-loading">Loading weather data...</div>
    }

    // derived from the JSON file where API was fetched
    const currentTemp = weatherData.current.temperature_2m;
    const maxTemp = weatherData.daily.temperature_2m_max[0];
    const minTemp = weatherData.daily.temperature_2m_min[0];

    return (
        <div className="weather-widget">
            <h3>Weather Update</h3>
            <p>Current Temperature: {currentTemp}°C</p>
            <p>Max Temperature: {maxTemp}°C</p>
            <p>Min Temperature: {minTemp}°C</p>
        </div>
    )
    
}

export default Weather;