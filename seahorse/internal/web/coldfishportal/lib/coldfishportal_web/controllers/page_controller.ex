defmodule ColdfishportalWeb.PageController do
  use ColdfishportalWeb, :controller

  def index(conn, _params) do
    render conn, "index.html"
  end
end
