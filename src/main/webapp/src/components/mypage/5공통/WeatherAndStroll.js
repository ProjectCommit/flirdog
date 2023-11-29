import axios from 'axios';
import { useState } from 'react';
import styled from 'styled-components';

const WeatherAndStroll = () => {
    const API_KEY = "1e7c80253e0b45e8952c959aa383dda5"; 
    const [location, setLocation] = useState('');
    const [result, setResult] = useState({});
    const url = `https://api.openweathermap.org/data/2.5/weather?q=${location},Korea&appid=${API_KEY}`;
    //https://api.openweathermap.org/data/2.5/weather?q=Seoul,Korea&appid=1e7c80253e0b45e8952c959aa383dda5 이거 긁어서 검색창에 넣고 test.json에 갖다붙이시오.
    const searchWeather = async (e) => {
        if(e.key === 'Enter') {
          try {
            const data = await axios({
              method: 'get',
              url: url,
            })
            setResult(data);
            console.log(data);
          } 
          catch(err) {
            alert(err);
          }
        }
      }
    return (
        <AppWrap>
        <div className="appContentWrap">
          <input
            placeholder="도시를 입력하세요"
            value={location}
            onChange={(e) => setLocation(e.target.value)}
            type="text"
            onKeyDown={searchWeather}
          />
          {Object.keys(result).length !== 0 && (
            <ResultWrap>
              <div className="city">{result.data.name}</div>
              <div className="temperature">
                {Math.round((result.data.main.temp - 273.15) * 10) / 10}°C
              </div>
              <div className="sky">{result.data.weather[0].main}</div>
            </ResultWrap>
          )}
        </div>
      </AppWrap>
    );
};

export default WeatherAndStroll;

const AppWrap = styled.div`
    width: 100vw;
    height: 100vh;
    border: 1px solid red;

    .appContentWrap {
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
        position: absolute;
        padding: 20px;
      }
      input {
        padding: 16px;
        border: 2px black solid;
        border-radius: 16px;
      }
    
    `;
    
    const ResultWrap = styled.div`
      margin-top: 60px;
      border: 1px black solid;
      padding: 10px;
      border-radius: 8px;
    
      .city {
        font-size: 24px;
      }
      .temperature {
        font-size: 60px;
        margin-top: 8px;
      }
      .sky {
        font-size: 20px;
        text-align: right;
        margin-top: 8px;
      }
`;