import axios from "axios"
import { useEffect, useState } from "react"

const ShowAmount = () =>{
    const [balance,setBalance] = useState(0)
    const url = "http://localhost:8080"

    useEffect(() =>{
        getBalance()
    },[])

    const getBalance = () =>{
        axios.get(url+"/users/getBalance").then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setBalance(result.data)
            }
        })
    }

    return (
        <div className="container">
            <br>
            </br>

            Current Balance of school is <b>{balance}</b> /- Rs.
        </div>
    )
}
export default ShowAmount