
import React, { Component } from 'react';


export class Register extends Component {

    render() {
        return (
            <div class="container z-depth-4">
                <div class="section">
                    <div class="row">
                        <nav>
                            <div class="nav-wrapper">
                                <div class="col s8"  >
                                    <h3 class="brand-logo col s8">Please Register</h3>
                                </div>
                            </div>
                        </nav>
                    </div>
                    <div class="row">
                        <form >
                            <div class="row">
                                <div class="input-field hoverable col s6">
                                    <i class="material-icons prefix">contacts</i>
                                    <input id="first_name" type="text" class="validate"></input>
                                    <label for="first_name">First Name</label>
                                </div>
                                <div class="input-field hoverable col s6">
                                    <i class="material-icons prefix">contacts</i>
                                    <input id="last_name" type="text" class="validate"></input>
                                    <label for="last_name">Last Name</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field hoverable col s6">
                                    <i class="material-icons prefix">vpn_key</i>
                                    <input id="password" type="password" class="validate"></input>
                                    <label for="password">Password</label>
                                </div>
                                <div class="input-field hoverable col s6">
                                    <i class="material-icons prefix">replay</i>
                                    <input id="password2" type="password" class="validate"></input>
                                    <label for="password2">Retype Password</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field hoverable col s6">
                                    <i class="material-icons prefix">account_circle</i>
                                    <input id="username" type="text" class="validate"></input>
                                    <label for="username">Username</label>
                                </div>
                                <div class="input-field hoverable col s6">
                                    <i class="material-icons prefix">email</i>
                                    <input id="email" type="email" class="validate"></input>
                                    <label for="email">Email</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field hoverable col s6">
                                    <i class="material-icons prefix">contact_phone</i>
                                    <input id="phonenumber" type="text" class="validate"></input>
                                    <label for="phonenumber">Phone Number</label>
                                </div>
                            </div>

                            <a class="waves-effect waves-light btn right hoverable">
                                <i class="large material-icons right">done</i>register
                    </a>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}