
import React, { Component } from 'react';


export class Register extends Component {
    constructor(props) {
        super(props);
        this.state = {
            firstname: '',
            lastname: '',
            password: '',
            confirmpassword: '',
            username: '',
            phonenumber: '',
            emailaddress: ''
        };

        this.handleInputChange = this.handleInputChange.bind(this);
        this.registerSubmit = this.registerSubmit.bind(this);
    }

    handleInputChange(event) {
        const target = event.target;
        const value = target.type === 'checkbox' ? target.checked : target.value;
        const name = target.name;

        this.setState({
            [name]: value
        });
    }

    registerSubmit(event) {
        event.preventDefault();
        const data = {
            firstname: this.state.firstname,
            lastname: this.state.lastname,
            password: this.state.password,
            confirmpassword: this.state.confirmpassword,
            username: this.state.username,
            phonenumber: this.state.phonenumber,
            emailaddress: this.state.emailaddress
        };
        fetch('/api/profile', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(response => response.json())
            .then(data => {
                this.setState({ forecasts: data, loading: false });
            });
    }

    render() {
        return (
            <div className="container z-depth-4">
                <div className="section card">
                    <div className="row">
                        <nav className="blue">
                            <div className="nav-wrapper">
                                <div className="col s8"  >
                                    <h3 className="brand-logo col s8 txtcolor">Please Register</h3>
                                </div>
                            </div>
                        </nav>
                    </div>
                    <div className="row">
                        <form >
                            <div className="row">
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">contacts</i>
                                    <input id="firstname" name="firstname" type="text" className="validate" value={this.state.firstname} onChange={this.handleInputChange}></input>
                                    <label htmlFor="firstname">First Name</label>
                                </div>
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">contacts</i>
                                    <input id="lastname" name="lastname" type="text" className="validate" value={this.state.lastname} onChange={this.handleInputChange}></input>
                                    <label htmlFor="lastname">Last Name</label>
                                </div>
                            </div>
                            <div className="row">
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">vpn_key</i>
                                    <input id="password" name="password" type="password" className="validate" value={this.state.password} onChange={this.handleInputChange}></input>
                                    <label htmlFor="password">Password</label>
                                </div>
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">replay</i>
                                    <input id="confirmpassword" name="confirmpassword" type="password" className="validate" value={this.state.confirmpassword} onChange={this.handleInputChange}></input>
                                    <label htmlFor="confirmpassword">Retype Password</label>
                                </div>
                            </div>
                            <div className="row">
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">account_circle</i>
                                    <input id="username" name="username" type="text" className="validate" value={this.state.username} onChange={this.handleInputChange}></input>
                                    <label htmlFor="username">Username</label>
                                </div>
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">email</i>
                                    <input id="emailaddress" name="emailaddress" type="email" className="validate" value={this.state.emailaddress} onChange={this.handleInputChange}></input>
                                    <label htmlFor="emailaddress">Email</label>
                                </div>
                            </div>
                            <div className="row">
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">contact_phone</i>
                                    <input id="phonenumber" name="phonenumber" type="text" className="validate" value={this.state.phonenumber} onChange={this.handleInputChange}></input>
                                    <label htmlFor="phonenumber">Phone Number</label>
                                </div>
                            </div>
                            <div className="row">
                                <div className="center-align">
                                    <a className="waves-effect waves-light hoverable blue btn-large" onClick={this.registerSubmit}>register</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}