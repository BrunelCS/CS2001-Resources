import { useState, useEffect } from 'react';
import axios from "axios";

function useFetchData(url,token) {
  const [data, setData] = useState(null);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    async function fetchData() {
      try {
        const response = await axios({
              method: 'get',
              url: url,
              headers: {"Authorization" : `Bearer ${token}`}
        })
        setData(response.data);
      } catch (error) {
        setError(error);
      } finally {
        setLoading(false);
      }
    }

    fetchData();
  }, [url]);

  return { data, error, loading };
}

export default useFetchData;
