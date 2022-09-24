const FeeRecordRows = ({r}) =>{
    return(
        <tr>
            <td>{r.studentId}</td>
            <td>{r.studentName}</td>
            <td>{r.gender}</td>
            <td>{r.std}</td>
            <td>{r.email}</td>
            <td>{r.mobile}</td>
            <td>{r.fees} /- Rs</td>
        </tr>
    )
}
export default FeeRecordRows