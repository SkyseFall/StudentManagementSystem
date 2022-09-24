import axios from "axios"

const ScheduleRow = ({s}) =>{
    const url = "http://localhost:8080"
    const RemoveSchedule = () =>{
        axios.delete(url+"/schedule/"+s.sessionId).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                window.alert("Schedule deleted successfully")
            }
        })
    }
    return(
        <tr>
            <td>{s.std}</td>
            <td>{s.subjectName}</td>
            <td>{s.tName}</td>
            <td>{s.startTime}</td>
            <td>{s.endTime}</td>
            <td>
                <button className="button-delete" onClick={RemoveSchedule}>Remove</button>
            </td>
        </tr>
    )
}
export default ScheduleRow