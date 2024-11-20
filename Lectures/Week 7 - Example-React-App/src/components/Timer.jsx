import React, { useState, useEffect } from 'react';

function Timer() {
  const [count, setCount] = useState(0);

  useEffect(() => {
    // Set up an interval to increment the count every second
    const intervalId = setInterval(() => {
      setCount((prevCount) => prevCount + 1);
    }, 1000);

    // Cleanup function to clear the interval when the component unmounts
    return () => {
      clearInterval(intervalId);
      console.log('Interval cleared');
    };
  }, []); // Empty dependency array means this effect runs only once

  return (
    <div className="maincontent">
      <h1>Timer: {count} seconds</h1>
    </div>
  );
}

export default Timer;
