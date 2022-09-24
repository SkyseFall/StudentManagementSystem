const RankRow = ({r},{c}) =>{
    return (
        <tr>
            <td>{c}</td>
            <td>{r.userId}</td>
            <td>{r.studentName}</td>
            <td>{r.gender}</td>
            <td>{r.percentage}</td>
            <td>{r.overallStatus}</td>
        </tr>
    )
}
export default RankRow