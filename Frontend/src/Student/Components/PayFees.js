import axios from "axios"
import { useEffect, useState } from "react"
import { useHistory } from "react-router"

const PayFees = (props) => {
    const userId = props.location.aboutProps.id.user
    const url = "http://localhost:8080"
    const [feesPaid, setFeesPaid] = useState(0)
    const [name, setName] = useState("")
    const [id, setId] = useState(0)
    const [dob, setDob] = useState("")
    const [gender, setGender] = useState("")
    const [mobile, setMobile] = useState(0)
    const [username, setUsername] = useState("")
    const [rollNo, setRollNo] = useState(0)
    const [std, setStd] = useState("")
    const [section, setSection] = useState("")

    const [payment, setPayment] = useState(0)
    const history = useHistory()

    useEffect(() => {
        getFeesPaid()
    }, [])

    const getFeesPaid = () => {
        const body = {
            "studentId": userId
        }

        console.log("Student ID : " + userId)
        console.log("Student Body : " + body)
        axios.post(url + "/student/getFeesPaid", body).then(Response => {
            const result = Response.data
            if (result.status == "success") {
                setFeesPaid(result.data)
                setName(result.name)
                setId(result.id)
                setDob(result.dob)
                setGender(result.gender)
                setMobile(result.mobile)
                setUsername(result.username)
                setRollNo(result.rollno)
                setStd(result.std)
                setSection(result.section)
            }
        })
    }
    const PayAmount = () => {
        const data = {
            "studentId": id,
            "fees": payment
        }
        axios.post(url + "/student/PayAmount", data).then(Response => {
            const result = Response.data
            console.log("PayAmount : "+payment)
            if (result.status == "success"  &&  payment != 0) {
                window.alert("You have paid " + payment + " /- Rupees to us.. Thank You!!")
                history.push("/StudentHome")
            }
            else
            {
                window.alert("Please Enter Amount !!!!")

            }
        })
    }
    return (<div>
        <div className="container"><h4 align="center">PayFees</h4>
            <hr></hr>
            <table className="table">
                <tbody>
                    <tr>
                        <td>Name</td>
                        <td>{name}</td>
                    </tr>
                    <tr>
                        <td>Registration Id</td>
                        <td>{id}</td>
                    </tr>
                    <tr>
                        <td>Date of Birth</td>
                        <td>{dob}</td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td>{gender}</td>
                    </tr>
                    <tr>
                        <td>Contact Number</td>
                        <td>{mobile}</td>
                    </tr>
                    <tr>
                        <td>Username</td>
                        <td>{username}</td>
                    </tr>
                    <tr>
                        <td>Roll number</td>
                        <td>{rollNo}</td>
                    </tr>
                    <tr>
                        <td>Class</td>
                        <td>{std}</td>
                    </tr>
                    <tr>
                        <td>Section</td>
                        <td>{section}</td>
                    </tr>
                    <tr>
                        <td>Amount Paid</td>
                        <td><b>{feesPaid}</b> /- Rupees</td>
                    </tr>
                </tbody>

            </table>
            Please Verify your details before paying fees
            <br />
            <br />
            <table className="table">
                <tbody>
                    <tr>
                        <td>Amount : </td>
                        <td>
                            <input type="number" required onChange={e => { setPayment(e.target.value) }} /> /- Rupees
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><button className="button-delete" onClick={PayAmount}>Pay</button></td>
                    </tr>
                    <tr></tr>
                </tbody>
            </table>

        </div>






    </div>
    )
}
export default PayFees