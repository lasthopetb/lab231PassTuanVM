USE [master]
GO
/****** Object:  Database [Quiz_Online]    Script Date: 08/06/2021 21:23:29 ******/
CREATE DATABASE [Quiz_Online] ON  PRIMARY 
( NAME = N'Quiz_Online', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\Quiz_Online.mdf' , SIZE = 2304KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Quiz_Online_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\Quiz_Online_log.LDF' , SIZE = 504KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Quiz_Online] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Quiz_Online].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Quiz_Online] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [Quiz_Online] SET ANSI_NULLS OFF
GO
ALTER DATABASE [Quiz_Online] SET ANSI_PADDING OFF
GO
ALTER DATABASE [Quiz_Online] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [Quiz_Online] SET ARITHABORT OFF
GO
ALTER DATABASE [Quiz_Online] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [Quiz_Online] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [Quiz_Online] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [Quiz_Online] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [Quiz_Online] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [Quiz_Online] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [Quiz_Online] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [Quiz_Online] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [Quiz_Online] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [Quiz_Online] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [Quiz_Online] SET  DISABLE_BROKER
GO
ALTER DATABASE [Quiz_Online] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [Quiz_Online] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [Quiz_Online] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [Quiz_Online] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [Quiz_Online] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [Quiz_Online] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [Quiz_Online] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [Quiz_Online] SET  READ_WRITE
GO
ALTER DATABASE [Quiz_Online] SET RECOVERY SIMPLE
GO
ALTER DATABASE [Quiz_Online] SET  MULTI_USER
GO
ALTER DATABASE [Quiz_Online] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [Quiz_Online] SET DB_CHAINING OFF
GO
EXEC sys.sp_db_vardecimal_storage_format N'Quiz_Online', N'ON'
GO
USE [Quiz_Online]
GO
/****** Object:  Table [dbo].[Quiz]    Script Date: 08/06/2021 21:23:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Quiz](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[accountid] [int] NOT NULL,
	[date] [date] NOT NULL,
	[result] [float] NOT NULL,
	[status] [varchar](50) NULL,
 CONSTRAINT [PK_Quiz] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Quiz] ON
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (1, 1, CAST(0xBA420B00 AS Date), 10, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (2, 1, CAST(0xBA420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (3, 2, CAST(0xBA420B00 AS Date), 5, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (4, 1, CAST(0xBA420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (5, 1, CAST(0xBA420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (6, 1, CAST(0xBA420B00 AS Date), 10, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (7, 2, CAST(0xBA420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (8, 2, CAST(0xBA420B00 AS Date), 3, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (9, 1, CAST(0xBA420B00 AS Date), 5, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (10, 1, CAST(0xBA420B00 AS Date), 3.3, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (11, 1, CAST(0xBA420B00 AS Date), 2, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (12, 1, CAST(0xBE420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (13, 1, CAST(0xBE420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (14, 1, CAST(0xBE420B00 AS Date), 7.5, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (15, 1, CAST(0xBE420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (16, 1, CAST(0xBE420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (17, 1, CAST(0xBE420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (18, 1, CAST(0xBE420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (19, 2, CAST(0xBE420B00 AS Date), 3.3, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (20, 2, CAST(0xBE420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (21, 1, CAST(0xBE420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (22, 1, CAST(0xBE420B00 AS Date), 10, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (23, 1, CAST(0xBE420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (24, 1, CAST(0xBE420B00 AS Date), 5, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (25, 1, CAST(0xBE420B00 AS Date), 5, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (26, 1, CAST(0xBE420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (27, 1, CAST(0xBE420B00 AS Date), 5, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (28, 1, CAST(0xBE420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (29, 1, CAST(0xBE420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (30, 1, CAST(0xC1420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (31, 1, CAST(0xC1420B00 AS Date), 10, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (32, 1, CAST(0xC6420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (33, 1, CAST(0xC6420B00 AS Date), 10, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (34, 1, CAST(0xC8420B00 AS Date), 6.6, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (35, 1, CAST(0xC8420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (36, 1, CAST(0xC8420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (37, 1, CAST(0xC8420B00 AS Date), 10, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (38, 1, CAST(0xC8420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (39, 1, CAST(0xC8420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (40, 1, CAST(0xC8420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (41, 1, CAST(0xC8420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (42, 1, CAST(0xC8420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (43, 1, CAST(0xC8420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (44, 1, CAST(0xC8420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (45, 1, CAST(0xC8420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (46, 1, CAST(0xC8420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (47, 1, CAST(0xC8420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (48, 1, CAST(0xC8420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (49, 1, CAST(0xC8420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (50, 1, CAST(0xC8420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (51, 1, CAST(0xC8420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (52, 1, CAST(0xC8420B00 AS Date), 5, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (53, 1, CAST(0xC8420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (54, 1, CAST(0xC8420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (55, 1, CAST(0xC8420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (56, 2, CAST(0xC8420B00 AS Date), 5, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (57, 2, CAST(0xC8420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (58, 1, CAST(0xC8420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (59, 2, CAST(0xC8420B00 AS Date), 10, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (60, 1, CAST(0xD1420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (61, 1, CAST(0xD1420B00 AS Date), 10, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (62, 1, CAST(0xD1420B00 AS Date), 9.9, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (63, 1, CAST(0xD1420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (64, 1, CAST(0xD1420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (65, 1, CAST(0xD1420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (66, 1, CAST(0xD1420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (67, 1, CAST(0xD1420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (68, 1, CAST(0xD1420B00 AS Date), 10, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (69, 1, CAST(0xD1420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (70, 1, CAST(0xD1420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (71, 1, CAST(0xD1420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (72, 1, CAST(0xD1420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (73, 1, CAST(0xD1420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (74, 1, CAST(0xD1420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (75, 1, CAST(0xD1420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (76, 1, CAST(0xD1420B00 AS Date), 10, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (77, 1, CAST(0xD1420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (78, 1, CAST(0xD1420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (79, 1, CAST(0xD1420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (80, 1, CAST(0xD1420B00 AS Date), 3.3, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (81, 1, CAST(0xD1420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (82, 1, CAST(0xD1420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (83, 1, CAST(0xD1420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (84, 1, CAST(0xD1420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (85, 11, CAST(0xD1420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (86, 1, CAST(0xD1420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (87, 1, CAST(0xD1420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (88, 1, CAST(0xD1420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (89, 1, CAST(0xD1420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (90, 1, CAST(0xD3420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (91, 2, CAST(0xD3420B00 AS Date), 5, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (92, 1, CAST(0xD4420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (93, 1, CAST(0xD4420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (94, 1, CAST(0xD4420B00 AS Date), 10, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (95, 1, CAST(0xD4420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (96, 1, CAST(0xD4420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (97, 1, CAST(0xD4420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (98, 1, CAST(0xD4420B00 AS Date), 10, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (99, 1, CAST(0xD6420B00 AS Date), 6.6, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (100, 1, CAST(0xD7420B00 AS Date), 0, N'not passed')
GO
print 'Processed 100 total records'
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (101, 1, CAST(0xD7420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (102, 1, CAST(0xD7420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (103, 1, CAST(0xD7420B00 AS Date), 10, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (104, 1, CAST(0xD7420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (105, 1, CAST(0xD7420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (106, 1, CAST(0xD7420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (107, 1, CAST(0xD7420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (108, 1, CAST(0xD7420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (109, 1, CAST(0xD7420B00 AS Date), 10, N'passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (110, 1, CAST(0xD7420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (111, 1, CAST(0xD7420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (112, 1, CAST(0xD7420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (113, 1, CAST(0xD7420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (114, 1, CAST(0xD7420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (115, 1, CAST(0xD7420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (116, 1, CAST(0xD7420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (117, 1, CAST(0xD7420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (118, 1, CAST(0xD7420B00 AS Date), 0, N'rejected')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (119, 1, CAST(0xD7420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (120, 1, CAST(0xD7420B00 AS Date), 0, N'not passed')
INSERT [dbo].[Quiz] ([id], [accountid], [date], [result], [status]) VALUES (121, 1, CAST(0xD7420B00 AS Date), 0, N'rejected')
SET IDENTITY_INSERT [dbo].[Quiz] OFF
/****** Object:  Table [dbo].[Question]    Script Date: 08/06/2021 21:23:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Question](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[question] [nvarchar](1000) NOT NULL,
	[option1] [nvarchar](1000) NOT NULL,
	[option2] [nvarchar](1000) NOT NULL,
	[option3] [nvarchar](1000) NOT NULL,
	[option4] [nvarchar](1000) NOT NULL,
	[answer] [varchar](50) NOT NULL,
	[createdate] [date] NOT NULL,
	[accountid] [int] NOT NULL,
 CONSTRAINT [PK_Question] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Question] ON
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [answer], [createdate], [accountid]) VALUES (46, N'12 * 3', N'36', N'24', N'38', N'28', N'1 ', CAST(0xC8420B00 AS Date), 1)
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [answer], [createdate], [accountid]) VALUES (47, N'Who is champion Euro 2016?', N'France', N'Portugal', N'Germany', N'Viet Nam', N'2 ', CAST(0xC8420B00 AS Date), 1)
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [answer], [createdate], [accountid]) VALUES (48, N'Who is champion AFF cup 2020?', N'Thai Land', N'England', N'Viet Nam', N'Malaysia', N'3 ', CAST(0xC8420B00 AS Date), 1)
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [answer], [createdate], [accountid]) VALUES (49, N'2 ^ 3', N'6', N'8', N'10', N'12', N'2 ', CAST(0xCB420B00 AS Date), 1)
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [answer], [createdate], [accountid]) VALUES (50, N'1 , 2 , 3 , 5 , 8 , 13 ', N'15', N'17', N'19', N'21', N'4 ', CAST(0xD1420B00 AS Date), 1)
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [answer], [createdate], [accountid]) VALUES (51, N'2 , 4 , 6 , 8 , 10 , 12 , 14 , ...', N'16', N'22', N'10', N'18', N'1 ', CAST(0xD1420B00 AS Date), 1)
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [answer], [createdate], [accountid]) VALUES (54, N'3 + 8 = ', N'11', N'12', N'13', N'14', N'1 ', CAST(0xD5420B00 AS Date), 1)
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [answer], [createdate], [accountid]) VALUES (55, N'9 / 3 = ', N'3', N'2', N'4', N'7', N'1 ', CAST(0xD5420B00 AS Date), 1)
INSERT [dbo].[Question] ([id], [question], [option1], [option2], [option3], [option4], [answer], [createdate], [accountid]) VALUES (56, N'22 + 33 = ', N'11', N'22', N'33', N'55', N'4 ', CAST(0xD5420B00 AS Date), 1)
SET IDENTITY_INSERT [dbo].[Question] OFF
/****** Object:  Table [dbo].[Account]    Script Date: 08/06/2021 21:23:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Account](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[type] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Account] ON
INSERT [dbo].[Account] ([id], [username], [password], [email], [type]) VALUES (1, N'1', N'1', N'1@gmail.com', N'teacher')
INSERT [dbo].[Account] ([id], [username], [password], [email], [type]) VALUES (2, N'2', N'1', N'2@gmail.com', N'student')
INSERT [dbo].[Account] ([id], [username], [password], [email], [type]) VALUES (3, N'test3', N'123', N'test1@Gamil.com', N'teacher')
INSERT [dbo].[Account] ([id], [username], [password], [email], [type]) VALUES (4, N'abcd', N'123', N'test1@gmail.com', N'student')
INSERT [dbo].[Account] ([id], [username], [password], [email], [type]) VALUES (5, N'test6', N'123', N'bac@a.a', N'student')
INSERT [dbo].[Account] ([id], [username], [password], [email], [type]) VALUES (6, N'test7', N'123', N'a@a.a.a', N'student')
INSERT [dbo].[Account] ([id], [username], [password], [email], [type]) VALUES (7, N'test8', N'123', N'a@a.a.a.a', N'teacher')
INSERT [dbo].[Account] ([id], [username], [password], [email], [type]) VALUES (8, N'test10', N'123', N'A@a.a', N'student')
INSERT [dbo].[Account] ([id], [username], [password], [email], [type]) VALUES (9, N'test11', N'123', N'a@a.a.a', N'student')
INSERT [dbo].[Account] ([id], [username], [password], [email], [type]) VALUES (10, N'test12323', N'123', N'abc@gmail.com', N'student')
INSERT [dbo].[Account] ([id], [username], [password], [email], [type]) VALUES (11, N'', N'', N'', N'')
INSERT [dbo].[Account] ([id], [username], [password], [email], [type]) VALUES (12, N'', N'', N'', N'')
INSERT [dbo].[Account] ([id], [username], [password], [email], [type]) VALUES (13, N'teacher', N'1', N'astrogurion@gmail.com', N'teacher')
SET IDENTITY_INSERT [dbo].[Account] OFF
