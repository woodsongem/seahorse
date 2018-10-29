import React, { Component } from 'react';

export class Login extends Component {
    constructor(props) {
        super(props);
    }
    handleInputChange(event) {
        const target = event.target;
        const value = target.type === 'checkbox' ? target.checked : target.value;
        const name = target.name;

        this.setState({
            [name]: value
        });
    }

    loginSubmit(event) {
        event.preventDefault();
    }
    render() {
        return (
            <div className="container z-depth-4">
                <div className="section card">
                    <div className="row">
                        <nav className="blue">
                            <div className="nav-wrapper">
                                <div className="col s8"  >
                                    <h3 className="brand-logo col s8 txtcolor">Login</h3>
                                </div>
                            </div>
                        </nav>
                    </div>
                    <div className="row">
                        <form >
                            <div className="row">
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">contacts</i>
                                    <input id="firstname" name="firstname" type="text" className="validate" onChange={this.handleInputChange}></input>
                                    <label htmlFor="firstname">First Name</label>
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