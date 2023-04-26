package com.intern.hrmanagementapi.constant;

public final class EndpointConst {

  private static final String ROOT_V1 = "/api/v1";

  public static final class Mail {

    public static final String BASE_PATH = ROOT_V1 + "/mails";
    public static final String SEND = "";
  }

  public static final class Employee {

    public static final String BASE_PATH = ROOT_V1 + "/employees";
    public static final String LIST = "/batch";
    public static final String SEARCH = "/search";
    public static final String DELETE_BY_ID = "{id}";
    public static final String UPDATE_BY_ID = "{id}";
    public static final String GET_BY_ID = "{id}";
  }


  public static final String AUTH_BASE_PATH = ROOT_V1 + "/auth";
  public static final String REGISTER = "/register";
  public static final String LOGIN = "/login";
  public static final String LOGOUT = "/logout";


  public static final String FILE_BASE_PATH = ROOT_V1 + "/files";
  public static final String FILE_UPLOAD = "";
  public static final String FILE_GET_BY_ID = "{id}";
  public static final String DELETE_GET_BY_ID = "{id}";
  public static final String FILE_UPLOAD_ONE = "/upload";
  public static final String FILE_DOWNLOAD = "/download/{id}";

  public static final class User {

    public static final String CHANGE_PASSWORD = "/change-password";
  }

  public static final class Department {

    public static final String BASE_PATH = ROOT_V1 + "/departments";
    public static final String GET_BY_ID = "{id}";
    public static final String UPDATE_BY_ID = "{id}";
    public static final String DELETE_BY_ID = "{id}";
  }

  public static final class Position {

    public static final String BASE_PATH = ROOT_V1 + "/positions";
    public static final String GET_BY_ID = "{id}";
    public static final String UPDATE_BY_ID = "{id}";
    public static final String DELETE_BY_ID = "{id}";
  }

  public static final class Salary {

    public static final String BASE_PATH = ROOT_V1 + "/salaries";
    public static final String GET_BY_ID = "{id}";
    public static final String UPDATE_BY_ID = "{id}";
    public static final String DELETE_BY_ID = "{id}";
  }

  public static final class Insurance {

    public static final String BASE_PATH = ROOT_V1 + "/insurances";
    public static final String GET_BY_ID = "{id}";
    public static final String UPDATE_BY_ID = "{id}";
    public static final String DELETE_BY_ID = "{id}";
  }

  public static final class Contract {

    public static final String BASE_PATH = ROOT_V1 + "/contracts";
    public static final String GET_BY_ID = "{id}";
    public static final String UPDATE_BY_ID = "{id}";
    public static final String DELETE_BY_ID = "{id}";
  }

}
