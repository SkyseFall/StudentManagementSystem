import axios from "axios"
import { useEffect, useState } from "react"
import ScheduleRow from "./SubComponents/ScheduleRow"

const ViewSchedule = (props) =>{
    const userId = props.location.aboutProps.id.user
    const [scheduleList,setScheduleList] = useState([])

    const url = "http://localhost:8080"
     useEffect(() =>{
        showScheduleByTeacher()
     },[])

    const showScheduleByTeacher = () =>{
        const body ={
            "userId" : userId
        }
        axios.post(url+"/schedule/getByTeacherId",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setScheduleList(result.data)
            }
        })
    }

    return (
        <div className="container">
            <h4 align="center">Schedule</h4>
            <b><hr></hr></b>
        <table className="table">
                <thead className="tableHead">
                    <tr>
                        <th>Class</th>
                        <th>Subject Name</th>
                        <th>Teacher Name</th>
                        <th>Start Time</th>
                        <th>End Time</th>
                    </tr>
                </thead>
                <tbody>
                        {                    
                            scheduleList.map((sl) =>{
                            return (
                                    <ScheduleRow s={sl} />
                                )
                            })
                        }
                </tbody>
            </table>
        </div>
    )
}
export default ViewSchedule