import styled from 'styled-components';
import {Link} from "react-router-dom";

export const NavBarContainer = styled.div`
  background: #284894;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  position: absolute;
  top: 0;
  width: 100vw;
  height: 80px;
  margin: 0;
  padding: 0;
  left: 0;
`

export const NavBarDiv = styled.div`
  display: flex;
  width: 80%;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
`

export const NavLogo = styled.div`
  padding-left: 30px;
`

export const NavLogoLink = styled(Link)`
  text-decoration: none;
  text-underline: none;
  color: white;
`

export const NavMenu = styled.ul`
  display: flex;
  margin-right: auto;
`

export const NavItem = styled.li`
  display: inline-block;
  margin-right: auto;
  padding-left: 20px;
`

export const NavItemLink = styled(Link)`
  text-decoration: none;
  text-underline: none;
  color: white;
  font-family: sans-serif;
`