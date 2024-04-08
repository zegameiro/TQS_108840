import { useState,useEffect } from 'react'
import { useNavigate } from 'react-router-dom'

import {
  FaChevronDown,
  FaLocationDot,
} from "react-icons/fa6";
import { FaMoneyBillWave, FaCalendar, FaClock, FaBus } from "react-icons/fa";
import { MdAirlineSeatReclineNormal } from "react-icons/md";

import Navbar from '../components/Navbar'
import axios from 'axios'

import { API_URL } from '../api'

const MyReservations = () => {

  const [reservations, setReservations] = useState([])
  const navigate = useNavigate()
  const fetchReservations = async () => {
    try {
      const res = await axios.get(API_URL + 'reservations/list');

      if (res.status === 200) {
        // Set the reservations state to the fetched reservations
        console.log(res.data)
        setReservations(res.data)
      }
    } catch (error) {
      console.error(error)
    }
  }

  useEffect(() => {
    fetchReservations()
  }, [])

  return (
    <div>
      <Navbar />
      <div className='bg-white h-screen px-[5rem] py-[2rem]'>
        <h1 className='text-4xl font-bold'>My Reservations</h1>
        <div className="divider bg-slate-600 h-0.5 rounded"></div>
        <div className="overflow-x-auto">
          {reservations.length > 0 ? (
            <table className="table text-black">
              <thead>
                <tr className="text-slate-600 text-lg">
                  <th></th>
                  <th className="items-center gap-1">First Name</th>
                  <th className="items-center gap-1">Last Name</th>
                  <th className="items-center gap-1">Phone Number <FaCalendar /></th>
                  <th className="items-center gap-1">Seat <FaMoneyBillWave /></th>
                  <th className="items-center gap-1">Bus Trip</th>
                </tr>
              </thead>
              <tbody>
                  {reservations.map((reservation, index) => (
                    <tr key={index}>
                      <th>{index + 1}</th>
                      <td>{reservation.firstName}</td>
                      <td>{reservation.lastName}</td>
                      <td>{reservation.phone}</td>
                      <td>{reservation.seat}</td>
                      <td>
                        <button className="btn btn-sm btn-outline btn-primary" onClick={() => navigate(`/reservation?id=${reservation.idBusTrip}`)}>
                          See Trip
                        </button>
                      </td>
                    </tr>
                  ))}
              </tbody>
            </table>
          ) : (
            <div className="text-2xl text-center mt-5">No reservations found</div>
          )}
        </div>
      </div>
      
    </div>
  )
}

export default MyReservations;