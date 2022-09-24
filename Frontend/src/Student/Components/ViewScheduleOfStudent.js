import axios from "axios"
import { useEffect, useState } from "react"
import ScheduleRow from "./SubComponents/ScheduleRow"

const ViewScheduleOfStudent = (props) => {
    const userId = props.location.aboutProps.id.user
    const [std, setStd] = useState("")
    const [scheduleList, setScheduleList] = useState([])

    const url = "http://localhost:8080"
    useEffect(() => {
        findClass()
    }, [])

    const findClass = () => {
        const body = {
            "studentId": userId
        }
        axios.post(url + '/student/findClass', body).then(Response => {
            const result = Response.data
            if (result.status == "success") {
                setStd(result.std)
            }
        })

    }

    const ShowSchedule = () => {
        const data = {
            "std": std
        }
        axios.post(url + "/schedule/getByClass", data).then(Response => {
            const result = Response.data
            if (result.status == "success") {
                setScheduleList(result.data)
            }
        })
    }
    return (
        <div className="container"><h4 > Schedule Of StudentID : {userId} of Class : {std}</h4>


            <div>
                <div><button className="button-delete" onClick={ShowSchedule}>Show Schedule</button></div>
            </div>
            <hr></hr>
            <table className="table">
                <thead>
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
                        scheduleList.map((sl) => {
                            return (
                                <ScheduleRow key={sl.toString()} s={sl} />
                            )
                        })
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ViewScheduleOfStudent