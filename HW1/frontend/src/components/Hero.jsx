import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

import {
  FaChevronDown,
  FaLocationDot,
  FaMapLocationDot,
} from "react-icons/fa6";
import { FaSearch } from "react-icons/fa";

import axios from "axios";
import { API_URL } from "../api";
import { bus1 } from "../images";

const Hero = () => {

  const navigate = useNavigate();
  const [fromCities, setFromCities] = useState([]);
  const [toCities, setToCities] = useState([]);
  const [date, setDate] = useState("");
  const [fromCity, setFromCity] = useState("");
  const [toCity, setToCity] = useState("");

  const fetchFromCities = async () => {
    try {
      const res = await axios.get(`${API_URL}bustrips/get_from_cities`);

      if (res.status === 200) {
        setFromCities(res.data);
      }
    } catch (error) {
      console.error(error);
    }
  };

  const fetchToCities = async () => {
    try {
      const res = await axios.get(`${API_URL}bustrips/get_to_cities`);

      if (res.status === 200) {
        setToCities(res.data);
      }
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    fetchFromCities();
    fetchToCities();
  }, []);

  return (
    <div
      className="hero min-h-screen"
      style={{ backgroundImage: `url(${bus1})` }}
    >
      <div className="hero-overlay bg-opacity-70"></div>
      <div className="hero-content text-center text-neutral-content">
        <div className="max-w-lg justify-center">
          <h1 className="mb-5 text-5xl font-bold text-nowrap">
            Welcome to Bus Wize
          </h1>
          <p className="mb-5">
            Welcome to BusWize, your go-to destination for hassle-free bus trip
            reservations. Browse, book, and embark on your journey with ease,
            all at your fingertips.
          </p>

          <div className="card w-[43rem] h-full bg-base-100 shadow-xl">
            <div className="card-body">
              <h2 className="card-title mb-3">
                Search for your ideal trip here
              </h2>
              <div className="flex flex-col ">
                <div className="flex flex-row justify-between">
                  <div className="dropdown">
                    <div
                      tabIndex={0}
                      role="button"
                      className="btn btn-primary btn-outline m-1 w-[17rem] justify-between"
                    >
                      <span className="flex flex-row gap-2">
                        {fromCity ? fromCity : "Choose your departure city"}{" "}
                        <FaLocationDot />
                      </span>
                      <span>
                        {" "}
                        <FaChevronDown />
                      </span>
                    </div>
                    <ul
                      tabIndex={0}
                      className="dropdown-content z-[1] menu p-2 shadow bg-base-200 rounded-box w-full"
                    >
                      {fromCities.length > 0 &&
                        fromCities.map((city, index) => (
                          <li key={index}>
                            <a onClick={() => setFromCity(city)}>{city}</a>
                          </li>
                        ))}
                    </ul>
                  </div>

                  <div className="divider divider-horizontal h-[11rem]"></div>

                  <div className="dropdown">
                    <div
                      tabIndex={0}
                      role="button"
                      className="btn btn-primary btn-outline m-1 w-[17rem] justify-between"
                    >
                      <span className="flex flex-row gap-2">
                        {toCity ? toCity : "Choose your departure city"}{" "}
                        <FaLocationDot />
                      </span>
                      <span>
                        {" "}
                        <FaChevronDown />
                      </span>
                    </div>
                    <ul
                      tabIndex={0}
                      className="dropdown-content z-[1] menu p-2 shadow bg-base-200 rounded-box w-full"
                    >
                      {toCities.length > 0 &&
                        toCities.map((city, index) => (
                          <li key={index}>
                            <a onClick={() => setToCity(city)}>{city}</a>
                          </li>
                        ))}
                    </ul>
                  </div>
                </div>
                <input
                  type="date"
                  placeholder="Choose a date" 
                  className="input input-bordered input-primary w-full mt-5"
                  onChange={(e) => setDate(e.target.value)}
                />
                <div className="flex flex-row space-x-4 justify-center pt-5">
                  {(fromCity || toCity || date) && (
                    <button
                      className="btn btn-outline"
                      onClick={() =>
                        navigate(`/bustrips?${fromCity && `&from=${fromCity}`}${toCity && `&to=${toCity}`}${date && `&date=${date}`}`)
                      }
                    >
                      Search <FaSearch />
                    </button>
                  )}
                  <button
                    className="btn btn-outline btn-secondary"
                    onClick={() => navigate(`/bustrips`)}
                  >
                    See all trips <FaMapLocationDot />
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Hero;
