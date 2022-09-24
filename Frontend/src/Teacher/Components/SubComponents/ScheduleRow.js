const ScheduleRow = ({s}) =>{
    return(
        <tr>
            <td>{s.std}</td>
            <td>{s.subjectName}</td>
            <td>{s.tName}</td>
            <td>{s.startTime}</td>
            <td>{s.endTime}</td>
        </tr>
    )
}
export default ScheduleRow