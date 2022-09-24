import axios from "axios";
import { useEffect, useState } from "react";
import { useHistory } from "react-router";
import RankRow from "./SubComponents/RankRow";

const ViewRanks = () => {
    const [classList, setClassList] = useState([])
    const [c, setC] = useState("1");
    const [rankList, setRankList] = useState([])
    let count = 0;
    const history = useHistory()

    const url = "http://localhost:8080"
    useEffect(() => {
        getClasses()
    }, [])

    const getClasses = () => {
        axios.get(url + "/class/getDistinctClasses").then(Response => {
            const result = Response.data
            if (result.status == "success") {
                setClassList(result.data)
            } else if (result.status == "zero") {
                window.alert(result.message)
                history.push('/AdminHome')
            }
        })
    }

    const getRanks = () => {
        const body = {
            "std": c
        }
        axios.post(url + "/marks/ranks", body).then(Response => {
            const result = Response.data
            if (result.status == "success") {
                setRankList(result.marksheetList)
            }
        })
    }
    return (
        

            <div className="container">

                Select Class :

                <select onChange={e => { setC(e.target.value) }}>
                    {
                        classList.map((l) => {
                            return (
                                <option value={l} key={l}>{l}</option>
                            )
                        })
                    }
                </select>
                <button className="button-small" onClick={getRanks}>Show Ranks</button>
                <br /><br />

               
                <table className="table">
                    <thead className="tableHead">
                        <tr>
                            <th>Rank</th>
                            <th>Registration No.</th>
                            <th>Name</th>
                            <th>Gender</th>
                            <th>Percentage</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            rankList.map((rank) => {
                                count++;
                                return (
                                    <tr key={rank.userId}>
                                        <td>{count}</td>
                                        <td>{rank.userId}</td>
                                        <td>{rank.studentName}</td>
                                        <td>{rank.gender}</td>
                                        <td>{rank.percentage}</td>
                                        <td>{rank.overallStatus}</td>
                                    </tr>
                                )
                            })
                        }
                    </tbody>
                </table>
                <br /><br />
                <br /><br />
                <br /><br />
                <br /><br />
                <br /><br />
            </div>
            )
}
            export default ViewRanks