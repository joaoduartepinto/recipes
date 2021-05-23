import React from "react";

import {FaUtensils} from 'react-icons/fa'

import {NavBarContainer, NavBarDiv, NavItem, NavItemLink, NavLogo, NavLogoLink, NavMenu} from "./NavBarElements";

const NavBar = () => {

    return (
        <>
            <NavBarContainer>
                <NavBarDiv>
                    <NavLogo>
                        <NavLogoLink to={"/"}>
                            <FaUtensils/>
                        </NavLogoLink>
                    </NavLogo>
                    <NavMenu>
                        <NavItem>
                            <NavItemLink>
                                About
                            </NavItemLink>
                        </NavItem>
                        <NavItem>
                            <NavItemLink>
                                Recipes
                            </NavItemLink>
                        </NavItem>
                    </NavMenu>
                </NavBarDiv>
            </NavBarContainer>
        </>
    )

}

export default NavBar;